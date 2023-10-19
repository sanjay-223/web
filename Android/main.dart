       import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(context) {
    return const MaterialApp(
      title: 'Calculator',
      home: CalculatorScreen(),
    );
  }
}

class CalculatorScreen extends StatefulWidget {
  const CalculatorScreen({super.key});
  @override
  State<CalculatorScreen> createState() {
    return _CalculatorScreenState();
  }
}

class _CalculatorScreenState extends State<CalculatorScreen> {
  TextEditingController num1Controller = TextEditingController();
  TextEditingController num2Controller = TextEditingController();
  TextEditingController operationController = TextEditingController();
  String result = '';

  void calculate() {
    double num1 = double.tryParse(num1Controller.text) ?? 0;
    double num2 = double.tryParse(num2Controller.text) ?? 0;
    String operation = operationController.text;

    double output = 0;
    String res;

    if (operation == '+') {
      output = num1 + num2;
      res = output.toString();
    } else if (operation == '-') {
      output = num1 - num2;
      res = output.toString();
    } else if (operation == '*') {
      output = num1 * num2;
      res = output.toString();
    } else if (operation == '/') {
      if (num2 != 0) {
        output = num1 / num2;
        res = output.toString();
      } else {
        res = 'Cannot divide by zero';
      }
    } else {
      res = 'Invalid operation';
    }

    setState(() {
      result = 'Result: $res';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Calculator'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextField(
              controller: num1Controller,
              keyboardType: TextInputType.number,
              decoration:
                  const InputDecoration(labelText: 'Enter first number'),
            ),
            TextField(
              controller: num2Controller,
              keyboardType: TextInputType.number,
              decoration:
                  const InputDecoration(labelText: 'Enter second number'),
            ),
            TextField(
              controller: operationController,
              decoration: const InputDecoration(
                  labelText: 'Enter operation (+, -, *, /)'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                calculate();
              },
              child: const Text('Calculate'),
            ),
            const SizedBox(height: 20),
            Text(
              result,
              style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
          ],
        ),
      ),
    );
  }
}
