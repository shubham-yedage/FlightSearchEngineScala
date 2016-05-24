import scala.io.Source

/**
  * Created by synerzip on 23/5/16.
  */
class SearchFlights(fList: List[String]) {

  def getFlights(depLoc: String, arrLoc: String, date: String, choice: Int): List[String] = {
    //return list
    var flightsList: List[String] = Nil
    fList.foreach { flightFileName => fList
      val resourcesStream = getClass.getResourceAsStream(flightFileName)
      val lines = Source.fromInputStream(resourcesStream).getLines
      lines.next()
      //return direct flights list
      val directFlights: List[String] = searchDirectFlights(lines, depLoc, arrLoc, date)
      flightsList = List.concat(flightsList, directFlights)

      //return connecting flights list
      //val depLocRelatedFlightList: List[String] = searchRelatedFlights(depLoc, date)
      //val depLocRelatedFlightList: List[String] = searchRelatedFlights(arrLoc, date)

    }
    flightsList
  }


  def searchDirectFlights(lines: Iterator[String], depLoc: String, arrLoc: String, date: String): List[String] = {
    val fList: Iterator[String] = for {
      line <- lines
      cols = line.split(",").map(_.trim)
      if (cols(1).equalsIgnoreCase(depLoc) && cols(2).equalsIgnoreCase(arrLoc) && cols(3).equalsIgnoreCase(date))
    } yield cols(0)
    fList.toList
  }
}
