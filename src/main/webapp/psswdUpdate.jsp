<%@page import="ma.ac.esi.referentielCompetences.model.ConnectBd"%>
<%
    // R�cup�rez l'email � partir de l'URL
    String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Gesion des Comp�tences</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="images/img-01.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" action="UpdatepsswdServlet" method="POST">
					<span class="login100-form-title">
						R�nitialiser votre mots de pass
					</span>
                    <input type="hidden" name="email" value="<%= email %>">
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="password" name="psswd" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
								<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="psswd1" placeholder="Confirmer votre mots de pass ">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					<div class="alert alert-success" role="alert" id="successAlert" style="display: none;">
							 <% if (request.getAttribute("message") != null) { %>
							 <%= request.getAttribute("message") %>
							 <% } %>
 					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Confirmer
						</button>
					</div>

					

					<div class="text-center p-t-136">
						<a class="txt2" href="Login2.jsp">
							Create your Account
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	
<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

  <script>
 $(document).ready(function() {

  <% if (request.getAttribute("message") != null) { %>
 // Affiche l'alerte
 $('#successAlert').show();
 // Masque l'alerte après 2 secondes (2000 millisecondes)
 setTimeout(function() {
 $('#successAlert').fadeOut('slow');
 }, 2000); // 2 secondes
 <% } %>
 });
 </script>
</body>
</html>