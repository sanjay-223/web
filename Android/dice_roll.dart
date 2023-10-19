import 'package:flutter/material.dart';
import 'dart:math';

final randomizer =
    Random(); //is we use this inside setState(), it create a new random() obj everytime and delete afrom memory, which lead to inefficient memory usage

class DiceRoll extends StatefulWidget {
  const DiceRoll({super.key});
  @override
  State<DiceRoll> createState() {
    return _DiceRoll();
  }
}

class _DiceRoll extends State<DiceRoll> {
  var img = "assets/dice1.png";
  void rollDice() {
    setState(() {
      var diceno = randomizer.nextInt(6) + 1;
      img = "assets/dice$diceno.png";
    });
  }

  @override
  Widget build(context) {
    return Container(
      color: Color.fromARGB(255, 38, 85, 242),
      child: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const SizedBox(
              height: 20,
            ),
            Image.asset(
              img,
              width: 200,
            ),
            /* const SizedBox(
                height: 20,
              ),*/

            TextButton(
                onPressed: rollDice,
                style: TextButton.styleFrom(
                    padding: const EdgeInsets.only(top: 20),
                    foregroundColor: Colors.black,
                    textStyle: const TextStyle(fontSize: 32)),
                child: const Text(
                  "Roll",
                  style: TextStyle(
                    fontSize: 28,
                    fontWeight: FontWeight.bold,
                  ),
                )),
          ],
        ),
      ),
    );
  }
}
