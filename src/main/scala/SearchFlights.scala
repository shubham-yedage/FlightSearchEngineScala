import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by synerzip on 23/5/16.
  */
class SearchFlights(fList: List[String]) {

  def getFlights(depLoc: String, arrLoc: String, date: String, choice: Int): List[Flight] = {
    //return list
    var flightsList: List[Flight] = Nil
    val directFlights=new ListBuffer[Flight]
    fList.foreach { flightFileName => fList

      val resourcesStream = getClass.getResourceAsStream(flightFileName)
      val lines = Source.fromInputStream(resourcesStream).getLines
      lines.next()

      //return direct flights list
      directFlights.appendAll(searchDirectFlights(lines, depLoc, arrLoc, date))

      //return connecting flights list
      //val depLocRelatedFlightList: List[String] = searchRelatedFlights(lines, depLoc, date)
      //val depLocRelatedFlightList: List[String] = searchRelatedFlights(lines, arrLoc, date)

    }
    flightsList=directFlights.toList
    flightsList
  }


  def searchDirectFlights(lines: Iterator[String], depLoc: String, arrLoc: String, date: String): List[Flight] = {
    val fList: Iterator[String] = for {
      line <- lines
      cols = line.split(",").map(_.trim)
      if (cols(1).equalsIgnoreCase(depLoc) && cols(2).equalsIgnoreCase(arrLoc) && cols(3).equalsIgnoreCase(date))
    } yield cols(0)
    fList.toList
  }
}
