import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.ArrayList

class Street {
    //get the capacity
    val capacity = 8 //capacity of the street
    private val countOfAllCars = 12 //all cars
    private var drivingCars: Int = 0 //all cars, now driving (12 or less)
    var allCars = ArrayList<Car>()

    //contructor
    init {
        for (i in 0..countOfAllCars - 1) {
            try { //Exception handling
                allCars.add(Car())
            } catch (e: Exception) {
                //do something usefull or useless
            }

        }
    }

    //
    fun countOfDrivingCars(): Int {
        drivingCars = 0 //new loop (like next hour)
        var driveIt: Boolean //drive the actual car from the list?
        for (i in 0..countOfAllCars - 1) {
            driveIt = allCars[i].isDriving()
            if (driveIt) {
                drivingCars ++
            }
        }
        return drivingCars
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            println("Welcome, here is a useless program for cars on a street!")
            val street = Street() //a new street was build
            val capacity = street.capacity
            var drivingCars: Int //how many cars are driving?
            val br = BufferedReader(InputStreamReader(System.`in`)) //without the BufferedReader I would not have the function "readLine()"
            while (true) { //endless loop
                println("By press enter to start a new round with cars, which will drive or stand  random ")
                try {
                    br.readLine() //after every enter, you get 1 time new cars
                } catch (e: IOException) {
                }

                drivingCars = street.countOfDrivingCars()
                print(drivingCars.toString() + "cars are driving! ")
                if (drivingCars <= capacity) {
                    print("all can drive")
                } else {
                    print("all are delayed")
                }
                println() //always new line
            }
        }
    }

}
