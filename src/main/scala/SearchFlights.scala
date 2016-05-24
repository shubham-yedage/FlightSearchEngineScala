import scala.io.Source

/**
  * Created by synerzip on 23/5/16.
  */
class SearchFlights(fList: List[String]) {

  def getFlights(depLoc: String, arrLoc: String, date: String, choice: Int): Unit = {
    //return list
    fList.foreach { flightFileName => fList
      val resourcesStream = getClass.getResourceAsStream(flightFileName)
      val lines = Source.fromInputStream(resourcesStream).getLines
      lines.next()
      //return list
      searchDirectFlights(lines, depLoc, arrLoc, date)
    }
  }


  def searchDirectFlights(lines: Iterator[String], depLoc: String, arrLoc: String, date: String): Unit = {
    var directFlights = for {
      line <- lines
      cols = line.split(",").map(_.trim)
      if (cols(1).equals(depLoc) && cols(2).equals(arrLoc) && cols(3).equals(date))
    }yield cols(0)
  }
}
