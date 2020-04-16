import 'package:bytebank2/http/webclient.dart';
import 'package:bytebank2/screens/dashboard.dart';
import 'package:bytebank2/theme/style.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(BytebankApp());
  findAll();
}

class BytebankApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: appTheme(),
      home: Dashboard(),
    );
  }
}
