import java.io.{File, FileNotFoundException}

object FlightParametersExtracter {


  def main(args: Array[String]) {


    try {
      //Initiate Files
      val dir = new File("/home/synerzip/codebase/FlightSearchEngineScala/src/main/resources")
      val files = dir.listFiles
      val fileList = for {
        file <- files
      } yield file.getName
      val searchFlight = new SearchFlightsApproach2(fileList.toList)

      //Initiate scanning for inputs
      def scanDetails(): Unit = {
        println("Hello User. Enter Search Details!Enter Departure Location:")
        val depLoc = scala.io.StdIn.readLine()
        println("Enter Arrival Location:")
        val arrLoc = scala.io.StdIn.readLine()
        println("Enter Date:")
        val date = scala.io.StdIn.readLine()
        println("Enter 1 To sort According To Fare 2 To sort According To Fare-Duration:")
        val choice = scala.io.StdIn.readInt()
        val flightList: List[Flight] = searchFlight.getFlights(depLoc, arrLoc, date, choice)
        flightList.foreach { flights =>
          println(flights.toString)
        }
      }
      scanDetails()
    }
    catch {
      case ex: NoSuchFieldException => {
        println(ex.getMessage)
      }
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }
      case ex: NullPointerException => {
        println("Null Pointer Exception")
      }
      case ex: NumberFormatException => {
        println("Improper Fields Exception")
      }
    }

  }
}
