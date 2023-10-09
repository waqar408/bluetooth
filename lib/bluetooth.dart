
import 'package:flutter/services.dart';


class Bluetooth {
  static final MethodChannel _channel =const  MethodChannel("bluetooth");
  static Future<String> yourMethod(String message) async {
    try {
      final String result =
      await _channel.invokeMethod('printMessage',{"message": message });
      return result;
    } catch (e) {
      return 'Error: $e';
    }
  }
  static Future<String?> getPlatformVersion() async {
    return null;

    // Your implementation here
  }
}

