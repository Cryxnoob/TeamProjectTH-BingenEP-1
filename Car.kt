class Car {
    internal var amDriving: Boolean = false //is this car driving now?

    //funktion, if the car is driving or not (random)

    fun isDriving(): Boolean {
            val value = Math.random() //random value between 0 and 1
            if (value < 0.5) { //half of the values
                amDriving = true  //car is driving
            } else {
                amDriving = false //car stands (drives not)
            }
            return amDriving  //return, if car is driving or not
        }
}
