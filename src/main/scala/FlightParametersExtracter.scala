

/**
  * Created by synerzip on 23/5/16.
  */
object FlightParametersExtracter {


  def main(args: Array[String]) {
    //=============================================
    //    val listOfFiles = {
    //      val path = getClass.getResource("/AIR_FRANCE.csv")
    //      val resources = new File(path.getPath)
    //      if (resources.exists && resources.isDirectory) {
    //        resources.listFiles
    //          .toList
    //          .foreach(file => println(file.getName))
    //      }
    //    }

    //==========================================
    //    var file:String=""
    //    val fileDir = new File("resources")
    //    val fileList=
    //      for {file <- fileDir.listFiles()
    //    }yield file.getAbsolutePath
    //
    //    for(path <- fileList)
    //      println(path)

    //    val resourcesPath = getClass.getResource("/AIR_FRANCE.csv")
    //    println(resourcesPath.getPath)
    //==========================================
    val fList = List("/AIR_FRANCE.csv", "/BRITISH_AIRWAYS.csv", "/LUFTHANSA_AIRWAYS.csv")
    val searchFlight = new SearchFlights(fList)

    def scanDetails(): Unit= {
      println("Hello User. Enter Search Details!Enter Departure Location:")
      val depLoc = scala.io.StdIn.readLine()
      println("Enter Arrival Location:")
      val arrLoc = scala.io.StdIn.readLine()
      println("Enter Date:")
      val date = scala.io.StdIn.readLine()
      println("Enter 1 To sort According To Fare 2 To sort According To Fare-Duration:")
      val choice = scala.io.StdIn.readInt()
      searchFlight.getFlights(depLoc, arrLoc, date, choice)
    }
   scanDetails
    //=======================================================
    //    val resourcesStream = getClass.getResourceAsStream("/AIR_FRANCE.csv")
    //    val lines = Source.fromInputStream(resourcesStream).getLines
    //    lines.next()
    //    lines.foreach { line => lines
    //      val cols = line.split(",").map(_.trim)
    //      //println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    //      println(cols(0))
    //    }
  }
}
