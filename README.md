# genetic-2048
Okay so I tried applying [my simple genetic algorithm](https://github.com/knazir/simple-ga) to the game of 2048.

CHRISTMAS UPDATE! I just had an idea while reading the One Punch Man manga actually... this is a bit of a tangent but in manga, creators will sometimes publish their manga as a lower-quality webcomic to see if the story/concept gets any traction. If the series seems to be popular, they'll go to the next step and start drawing it professionally (or find someone to do it). 

ANYWAYS.... the idea is that instead of swapping moves at some rate, (which really doesn't work in a game where earlier moves can have an impact on later successes) I should "evolve" each population by adding on a new move to the most successful individuals and see where that takes the fitness. I'll try to implement that over the next few days...
___
Currently the graph outputs both the score and the largest tile before losing as individual series. I can't seem to get it to learn how to get better at 2048 though... Currently, each individual is basically an array of the Move enumerated type (either UP, DOWN, LEFT, or RIGHT). Crossing over works the same and moves are swapped. However, I'm realizing now that this does not guarnatee better performance at all.. Each individual simulates a game of 2048 by instantiating the game class and treating its Move array as keystrokes. Also, all game instances use a seed to ensure that the same game is being played given the same set of moves.

I wonder if this problem can actually be solved by this algorithm. I shall continue thinking...
___
This small project is possible thanks to [bulenkov's 2048 Java implementation](https://github.com/bulenkov/2048) which I modified to use in each individual's simulation. A big thank you!
___
Here is a sample run of trying to find a solution that gets the 512 tile with a population size of 100:
![alt tag](http://i.imgur.com/QrFKFni.png)

It's completely random how well the individual does. I'm not sure if there's a way using just this algoritihm to combine move sets into a better one...
