import java.util.ArrayList

fun main(args: Array<String>) {

    val streetCap = 8; // Capacity of street
    val countOfAllCars = 25; //Number of cars
    var drivingCars: Int = 0 // Number of cars that want to drive
    var allCars = ArrayList<Car>(); // Array of cars


    for (i in 0..countOfAllCars - 1) {
        try { //Exception handling
            allCars.add(Car())
        } catch (e: Exception) {
            //do something usefull or useless
        }

    }

    var driveIt: Boolean
    for (i in 0..countOfAllCars - 1) {    // Count the number of driving cars
        driveIt = allCars[i].isDriving()
        if (driveIt) {
            drivingCars ++
        }
    }
    println(drivingCars.toString() + " cars are driving! ") //Printnumber of cars that want to drive
    if (drivingCars <= streetCap) { // check if they are delayed or not
        print("all can drive")
    } else {
        print("all are delayed")
    }

}
class Car {
    internal var amDriving: Boolean = false //is this car driving now?

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



