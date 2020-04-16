import 'package:flutter/material.dart';

ThemeData appTheme() {
  return ThemeData(
    primaryColor: Colors.pink[600],
    accentColor: Colors.pinkAccent[700],
    buttonTheme: ButtonThemeData(
      buttonColor: Colors.pinkAccent[700],
      textTheme: ButtonTextTheme.primary,
    ),
  );
}
