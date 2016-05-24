//import scala.collection.mutable.ListBuffer
//import scala.io.Source
//
///**
//  * Created by synerzip on 23/5/16.
//  */
//class SearchFlights(fList: List[String]) {
//
//
//  def getFlights(depLoc: String, arrLoc: String, date: String, choice: Int): List[Flight] = {
//    //return list
//    val directFlights = new ListBuffer[Flight]
//    val depLocRelatedFlights = new ListBuffer[Flight]
//    val arrLocRelatedFlights = new ListBuffer[Flight]
//
//    //Get list of direct flights- Flight List from depLoc- Flight List to arrLoc
//    fList.foreach { flightFileName =>
//      val resourcesStream = getClass.getResourceAsStream(flightFileName)
//      val lines = Source.fromInputStream(resourcesStream).getLines
//      lines.next()
//
//      //return direct flights list
//      directFlights.appendAll(searchDirectFlights(lines, depLoc, arrLoc, date))
//
//      //return depLoc-arrLoc flights list
//      depLocRelatedFlights.appendAll(searchRelatedFlights(lines, depLoc, date, 1))
//      arrLocRelatedFlights.appendAll(searchRelatedFlights(lines, arrLoc, date, 2))
//    }
//    directFlights.toList
//    //val connFlights1 = depLocRelatedFlights.toList.filter(_._arrival.equals(depLoc)).filter(_._depDate.equals(date))
//
//
//
//  }
//
//
//  def searchDirectFlights(lines: Iterator[String], depLoc: String, arrLoc: String, date: String): List[Flight] = {
//    var tempFlightListBuff = new ListBuffer[Flight]
//    lines.foreach {
//      line =>
//        val cols = line.split(",").map(_.trim)
//        if (cols(1).equalsIgnoreCase(depLoc) && cols(2).equalsIgnoreCase(arrLoc) && cols(3).equalsIgnoreCase(date)) {
//          tempFlightListBuff.+=(new Flight(cols(0), cols(1), cols(2), cols(3), cols(4).toInt, cols(5).toFloat, cols(6).toFloat))
//        }
//    }
//    tempFlightListBuff.toList
//  }
//
//  def searchRelatedFlights(lines: Iterator[String], Loc: String, date: String, i: Int): List[Flight] = {
//    var tempFlightListBuff = new ListBuffer[Flight]
//    lines.foreach {
//      line =>
//        val cols = line.split(",").map(_.trim)
//        if (cols(i).equalsIgnoreCase(Loc) && cols(3).equalsIgnoreCase(date)) {
//          tempFlightListBuff.+=(new Flight(cols(0), cols(1), cols(2), cols(3), cols(4).toInt, cols(5).toFloat, cols(6).toFloat))
//        }
//    }
//    tempFlightListBuff.toList
//  }
//
//}
