package com.example.bluetooth

import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.annotation.NonNull
import c.tlgbltcn.library.BluetoothHelper
import c.tlgbltcn.library.BluetoothHelperListener

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** BluetoothPlugin */
class BluetoothPlugin : FlutterPlugin, MethodCallHandler,BluetoothHelperListener {

  private lateinit var channel: MethodChannel
  var context : Context? = null
  var bluetoothHelper : BluetoothHelper?  = null
  var deviceList : ArrayList<String> = ArrayList()


  override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(binding.binaryMessenger, "bluetooth")
    channel.setMethodCallHandler(this)
    context = binding.applicationContext
    bluetoothHelper?.registerBluetoothStateChanged()

  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
    bluetoothHelper?.unregisterBluetoothStateChanged()

  }

  override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
    when (call.method) {
      /*"printMessage" -> {
        BluetoothHelper(context!!, this@BluetoothPlugin)
          .create()
        if (bluetoothHelper!!.isBluetoothScanning()) bluetoothHelper!!.stopDiscovery()
        else bluetoothHelper!!.startDiscovery()
        var message = "my message"
        if (message != null) {
          printMessage(message)
          result.success("Message printed: $message")
        } else {
          result.error("MISSING_ARGUMENT", "Message argument is missing", null)
        }
      }
      else -> {
        result.notImplemented()
      }*/
      "printMessage" -> {
        // Create BluetoothHelper and initiate scan
        bluetoothHelper = BluetoothHelper(context!!, this@BluetoothPlugin)
          .create()
        if (bluetoothHelper!!.isBluetoothScanning()) {
          bluetoothHelper!!.stopDiscovery()
        } else {
          bluetoothHelper!!.startDiscovery()
        }

        Handler(Looper.getMainLooper()).postDelayed({
          result.success(deviceList.toString())
        }, 4000)
      }
      else -> {
        result.notImplemented()
      }
    }
  }



  override fun getBluetoothDeviceList(device: BluetoothDevice?) {
    deviceList.add(device!!.toString())

  }

  override fun onDisabledBluetooh() {
  }

  override fun onEnabledBluetooth() {
  }

  override fun onFinishDiscovery() {
  }

  override fun onStartDiscovery() {
  }


}