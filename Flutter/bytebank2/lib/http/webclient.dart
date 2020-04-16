import 'package:bytebank2/http/interceptors/logging_interceptor.dart';
import 'package:http/http.dart';
import 'package:http_interceptor/http_client_with_interceptor.dart';

void findAll() async {
  final Client http = HttpClientWithInterceptor.build(
    interceptors: [LoggingInterceptor()],
  );
  final Response response = await http.get('http://192.168.0.100:8080/transactions');
  print(response.body);
}
b
