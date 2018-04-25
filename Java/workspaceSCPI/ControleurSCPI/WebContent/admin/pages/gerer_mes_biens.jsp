<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ecetech.bti3.projetIT.scpi.beans.*" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SCPI ADMIN</title>

    <!-- Bootstrap Core CSS -->
    <link href="./admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="./admin/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="./admin/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="./admin/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body >

    <div id="wrapper">

<!-- Navigation -->


<%@include file="header.jsp" %>
   

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">SCPI</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
               <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Liste des Biens</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Type</th>
                  <th>Spécifité</th>
                  <th>Statut</th>
                  <th>Superficie</th>                  
                  <th>Opérations</th>
                </tr>
              </thead>
 			
              <tbody>
              <% ArrayList<Bien> allB = (ArrayList<Bien>)request.getAttribute("biens"); 
              	System.out.println("jsp");
 				for(int i=0; i<allB.size(); i++)
 				{
	 				System.out.println(allB.get(i).toString());
 					out.println("<tr>");
	 				out.println("<td>"+allB.get(i).getType()+"</td>");
	 				out.println("<td>"+allB.get(i).getSpecificites()+"</td>");
	 				if(allB.get(i).getStatut() == 0){
	 					out.println("<td>en vente</td>");
	 				}
	 				else if(allB.get(i).getStatut() == 1){
	 					out.println("<td>vendu</td>");
	 				}
	 				out.println("<td>"+allB.get(i).getTaille()+"m<sup>2</sup></td>");
// 	 				out.println("<td>"+allB.get(i).getType()+"</td>"); // adresse
	 				out.println("<td><button type='button' class='btn btn-success'>Mettre en vente</button> -<a class='btn btn-info' href='#' >Détails</a></td>");
	 				out.println("</tr>");
 				}
 				
 			%>
              </tbody>
            </table>
          </div>
        </div>
      </div> 
            </div>
            <!-- /.row -->
            
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="./admin/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./admin/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="./admin/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="./admin/dist/js/sb-admin-2.js"></script>

</body>

</html>
