import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by synerzip on 24/5/16.
  */
class SearchFlightsApproach2(fList: List[String]) {


  def getFlights(depLoc: String, arrLoc: String, date: String, choice: Int): List[Flight] = {
    var tempFlightListBuff = new ListBuffer[Flight]
    fList.foreach { flightFileName =>
      val resourcesStream = getClass.getResourceAsStream(flightFileName)
      val lines = Source.fromInputStream(resourcesStream).getLines
      lines.next()

      lines.foreach {
        line =>
          val cols = line.split(",").map(_.trim)
          tempFlightListBuff.+=(new Flight(cols(0), cols(1), cols(2), cols(3), cols(4).toInt, cols(5).toFloat, cols(6).toFloat))
      }
    }
    val flightList = tempFlightListBuff.toList.filter(_.depDate.equalsIgnoreCase(date))
    //Direct Flights
    def filterDirectFlights(flight: Flight): Boolean = return flight.departure.equalsIgnoreCase(depLoc) && flight.arrival.equalsIgnoreCase(arrLoc)
    val directFlights = flightList.filter(filterDirectFlights)

    //Connecting Flights
    val connFlights1 = flightList.filter(_.departure.equalsIgnoreCase(depLoc))
    val conFlights2 = flightList.filter(_.arrival.equalsIgnoreCase(arrLoc))


    directFlights.:::(conFlights2).:::(connFlights1)
  }

}