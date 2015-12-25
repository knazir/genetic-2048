# genetic-2048
Okay so I tried applying [my simple genetic algorithm](https://github.com/knazir/simple-ga) to the game of 2048.

Currently the graph outputs both the score and the largest tile before losing as individual series. I can't seem to get it to learn how to get better at 2048 though... Currently, each individual is basically an array of the Move enumerated type (either UP, DOWN, LEFT, or RIGHT). Crossing over works the same and moves are swapped. However, I'm realizing now that this does not guarnatee better performance at all.. Each individual simulates a game of 2048 by instantiating the game class and treating its Move array as keystrokes.

I wonder if this problem can actually be solved by this algorithm. I shall continue thinking...
___
This small project is possible thanks to [bulenkov's 2048 Java implementation](https://github.com/bulenkov/2048) which I modified to use in each individual's simulation. A big thank you!
___
Here is a sample run of trying to find a solution that gets the 512 tile with a population size of 100:
![alt tag](http://i.imgur.com/QrFKFni.png)

It's completely random how well the individual does. I'm not sure if there's a way using just this algoritihm to combine move sets into a better one...
