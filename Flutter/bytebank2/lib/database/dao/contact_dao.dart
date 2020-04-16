import 'package:bytebank2/models/contact.dart';
import 'package:sqflite/sqflite.dart';

import '../app_database.dart';

class ContactDao {
  static const String createTableSql = 'CREATE TABLE $_tableName ('
      '$_id INTEGER PRIMARY KEY, '
      '$_name TEXT, '
      '$_accountNumber INTERGER'
      ')';
  static const String _tableName = 'contacts';
  static const String _id = 'id';
  static const String _name = 'name';
  static const String _accountNumber = 'account_number';

  Future<int> save(Contact contact) async {
    final Database db = await getDatabase();
    Map<String, dynamic> contactMap = toMap(contact);
    return db.insert(_tableName, contactMap);
  }

  Map<String, dynamic> toMap(Contact contact) {
    final Map<String, dynamic> contactMap = Map();
    contactMap[_name] = contact.name;
    contactMap[_accountNumber] = contact.accountNumber;
    return contactMap;
  }

  Future<List<Contact>> findAll() async {
    final Database db = await getDatabase();
    List<Contact> contactsList = await toList(db);

    return contactsList;
  }

  Future<List<Contact>> toList(Database db) async {
    final List<Contact> contactsList = List();
    (await db.query(_tableName)).forEach(
      (Map<String, dynamic> map) => contactsList.add(
        Contact(
          map[_id],
          map[_name],
          map[_accountNumber],
        ),
      ),
    );
    return contactsList;
  }
}
