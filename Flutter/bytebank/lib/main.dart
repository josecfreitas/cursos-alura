import 'package:bytebank/screens/transferencia/lista_transferencia.dart';
import 'package:bytebank/theme/style.dart';
import 'package:flutter/material.dart';

void main() => runApp(BytebankApp());

class BytebankApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: appTheme(),
      home: ListaTransferencia(),
    );
  }
}

