using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using Renaissance.Models;

namespace Renaissance.Controllers
{
    public class HomeController : Controller
    {

        public ActionResult Index()
        {
            return View();
        }

        [Route("home/signin")]
        public ActionResult SignIn()
        {
            return View();
        }

        [HttpPost]
        public ActionResult SignIn(UserSignIn usi, string returnUrl)
        {
            if (ModelState.IsValid)
            {
                UserSignIn UM = new UserSignIn();
                string password = UM.GetUserPassword(usi.userName);
                if (string.IsNullOrEmpty(password))
                    ViewBag.noPasswordMessage =  "The user login or password provided is incorrect.";
                else {
                    if (usi.password.Equals(password)) {
                        FormsAuthentication.SetAuthCookie(usi.userName, true);
                        Session["userName"] = usi.userName.ToString();
                        return RedirectToAction("Homepage", "Home",usi.userName);
                    } else {
                        ViewBag.wrongPasswordMessage = "The password provided is incorrect.";
                    }
                }
            }
            return View(usi);
            // If we got this far, something failed, redisplay form return View(ULV);
        }

        //[Authorize]
        public ActionResult SignOut()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Index", "Home");
        }

        public ActionResult Homepage()
        {
            return View();
        }
        

        

        public ActionResult Contact()
        {
            ViewBag.themessage = "having troube? send us a message";
            return View();
        }
        [HttpPost]
        public ActionResult Contact(string message)
        {
            ViewBag.themessage = "thanks we got the message";
            return View();
        }

    }
}