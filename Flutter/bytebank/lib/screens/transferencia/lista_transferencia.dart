import 'package:bytebank/models/transferencia.dart';
import 'package:flutter/material.dart';

import 'formulario_transferencia.dart';

class ListaTransferencia extends StatefulWidget {
  final List<Transferencia> _listaDeTransferencias = List();

  @override
  State<StatefulWidget> createState() {
    return _ListaTransferenciaState();
  }
}

class _ListaTransferenciaState extends State<ListaTransferencia> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Transferências'),
      ),
      body: ListView.builder(
        itemCount: widget._listaDeTransferencias.length,
        itemBuilder: (context, index) =>
            _ItemTransferencia(widget._listaDeTransferencias[index]),
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) {
              return FormularioTransferencia();
            }),
          ).then(
            (transferencia) => addToList(transferencia),
          );
        },
      ),
    );
  }

  void addToList(transferencia) {
    if (transferencia != null) {
      setState(() {
        widget._listaDeTransferencias.add(transferencia);
      });
    }
  }
}

class _ItemTransferencia extends StatelessWidget {
  final Transferencia _transferencia;

  _ItemTransferencia(this._transferencia);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        leading: Icon(Icons.monetization_on),
        title: Text('R\$ ' + _transferencia.valor.toString()),
        subtitle: Text(_transferencia.numeroConta.toString()),
      ),
    );
  }
}
