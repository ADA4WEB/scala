package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._


object Application extends Controller {
  val form = Form(
    tuple(
      "a" -> text,
      "b" -> text,
      "c" -> text
    )
  )

  def index = Action {
    Ok(views.html.index())
  }

  def submit = Action { implicit request =>
    val (a, b, c) = form.bindFromRequest.get
    
    //val d=b.toInt*b.toInt-4*a.toInt*c.toInt
    val d=delta(a.toInt,b.toInt,c.toInt)
    var x1: Double=0
    	var x2: Double=0
    if (d>0) {
    	//x1=(-b.toInt+4*c.toInt)/2*a.toInt
    	//x2=(-b.toInt-4*c.toInt)/2*a.toInt
    	x1=solution1(a.toInt,b.toInt,c.toInt)
    	x2=solution2(a.toInt,b.toInt,c.toInt)
    	
    	Ok("delta="+d+"\n x1="+x1.toString+", x2="+x2.toString)
    	}else {
    	Ok("delta="+d+"\n NO Solution")
    	}
    
  }
  
  
  def delta(a: Int,b: Int,c: Int): Int = b*b-4*a*c
  def solution1(a: Int,b: Int,c: Int): Double = (-b+Math.sqrt(c))/2*a
  def solution2(a: Int,b: Int,c: Int): Double = (-b-Math.sqrt(c))/2*a
}