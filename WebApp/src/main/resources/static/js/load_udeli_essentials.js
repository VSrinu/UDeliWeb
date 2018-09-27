document.write('<link rel="stylesheet" type="text/css" href="css/style.css" />');
document.write('<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />');
document.write('<script src="js/jquery.js" type="text/javascript"></script>');

document.getElementById("myNav").innerHTML =
	"<ul id='navLinks'>"
	+ "<li><a href='index.html'>Home</a></li>"
	+ "<li><a href='about.html'>About</a>"
	+ "<li><a href='donate.html'>Donate</a></li>"
	+ "</ul>";