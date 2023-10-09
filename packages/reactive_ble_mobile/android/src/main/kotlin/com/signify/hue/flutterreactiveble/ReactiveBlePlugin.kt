package com.signify.hue.flutterreactiveble

import android.content.Context
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.Result

class ReactiveBlePlugin : FlutterPlugin, MethodChannel.MethodCallHandler {
    private lateinit var pluginController : PluginController  = PluginController()

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        val channel = MethodChannel(binding.binaryMessenger, "flutter_reactive_ble_method")
        channel.setMethodCallHandler(this)

        pluginController.initialize(binding.binaryMessenger, binding.applicationContext)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        pluginController.deinitialize()
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        pluginController.execute(call, result)
    }
}
