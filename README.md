# bluetooth_plugin

Bluetooth Scan And Discover Devices

## Getting Started

To use this plugin, add bluetooth_plugin as a dependency in your pubspec.yaml file.

Minimal Example:
This is an example method for you to get the out put

bluetoothScan() async {

                 result = await Bluetooth.yourMethod("hello there");
                 setState(() {
                 // This call to setState tells the Flutter framework that something has
                 // changed in this State, which causes it to rerun the build method below
                 // so that the display can reflect the updated values. If we changed
                 // _counter without calling setState(), then the build method would not be
                // called again, and so nothing would appear to happen.
               result ='Nearby Bluetooth Devices: $result';
               });
               print('Sum: $result');
}

