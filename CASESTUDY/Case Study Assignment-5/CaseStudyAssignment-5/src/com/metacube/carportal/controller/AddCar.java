/**
 * Case Study- Assignments
Phase 5
Duration (Number of Hrs)

Assignment 1: Implement CarSales website as designed in prototype in phase 3. 
Implement all the use cases as designed in phase 3. Follow the layered architecture as discussed in the class.
 Use all the design patterns as discussed ie MVC-2, Facade, DAO, VO, Service and Factory. 
 Following use cases are must for the implementation.

Create Car Use case
Edit Car Use case
Search Car based on certain features as defined in use case
Login for administrator
Create/Edit only for administrator

 */
package com.metacube.carportal.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.carportal.model.Car;
import com.metacube.carportal.service.CarPortalService;
import com.metacube.carportal.service.Validation;

/**
 * @Deepali
 * Servlet implementation class AddCar
 */
@WebServlet("/add-car")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**For adding new car
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		CarPortalService service=new CarPortalService();
		//Validation on Car details
				String message=Validation.validationOnCarDetails(request.getParameter("make"), request.getParameter("model"), request.getParameter("engineInCC"), request.getParameter("fuelCapacity"), request.getParameter("milage"), request.getParameter("price"),request.getParameter("roadTax"));
	
		if (message.charAt(0)=='1') {
			// redirecting the response to add car page
			response.sendRedirect("addCar.jsp?message="
					+ URLEncoder.encode(message.substring(1), "UTF-8"));
		} else {
			//insertion of car in table
			int insert =service.creatingNewCar(new Car((String) request.getParameter("make"),
									(String) request.getParameter("model"),
									Double.parseDouble(request
											.getParameter("engineInCC")),
									Double.parseDouble(request
											.getParameter("fuelCapacity")),
									Double.parseDouble(request
											.getParameter("milage")), Double
											.parseDouble(request
													.getParameter("price")),
									Double.parseDouble(request
											.getParameter("roadTax")), ""));
			if (insert == 1) {//insertion of car successful
				
				//redirected to insert image of car
				request.setAttribute("make", request.getParameter("make"));
				request.setAttribute("model", request.getParameter("model"));
				System.out.println("yhgh"+request.getParameter("make"));
				RequestDispatcher rd = request
						.getRequestDispatcher("/addImageOfCar.jsp");
				rd.forward(request, response);
			} else {//if insertion not possible
				//redirected to add car again 
				
				response.sendRedirect("addCar.jsp?message="
						+ URLEncoder.encode("Car not inserted successfully or Model Is Already Available", "UTF-8"));
			}
		}
	}

	/**To insert imade path of car in database
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CarPortalService service=new CarPortalService();
		//getting image name and path 
		String image_path = uploadFile(request, response);
		//getting company name of car
		HttpSession session = request.getSession(true);
		String make = (String) session.getAttribute("make");
		String model = (String) session.getAttribute("model");
		System.out.println("dsfrs"+make+"rfcrv"+model);
		//inserting image path of car
		int insert =service.insertingImageOfCar(image_path, make, model);
		if (insert == 1) {//if inserted successfully
			//redirect to admin home page
			request.setAttribute("username", session.getAttribute("username"));
			RequestDispatcher rd = request.getRequestDispatcher("/admin-home");
			rd.forward(request, response);
		} else {//if not inserted successfully
			//redirect again to add image of car page
			request.setAttribute("message", "Car Image not inserted");
			request.setAttribute("make", request.getParameter("make"));
			RequestDispatcher rd = request
					.getRequestDispatcher("/addImageOfCar.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @param request: request of servlet
	 * @param response :response of servlet
	 * @return :image path of car
	 */
	private String uploadFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String saveFile = "";
		//getting content type of image
		String contentType = request.getContentType();
		//checking if content type is multipart or form data or not
		if ((contentType != null)&& (contentType.indexOf("multipart/form-data") >= 0)) {
			DataInputStream in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			while (totalBytesRead < formDataLength) {
				try {
					byteRead = in.read(dataBytes, totalBytesRead,
							formDataLength);
				} catch (IOException e) {
					e.printStackTrace();
				}
				totalBytesRead += byteRead;
			}
			
			String file = new String(dataBytes);
			saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
					saveFile.indexOf("\""));
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,
					contentType.length());
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
		
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			//creating that image at given path
			File ff = new File(
					"E:/Java/eclipse/CaseStudyAssignment-5/WebContent/images/"
							+ saveFile);
			FileOutputStream fileOut = null;
			try {
				fileOut = new FileOutputStream(ff);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			fileOut.write(dataBytes, startPos, (endPos - startPos));

			fileOut.flush();
			fileOut.close();
		}
		return "images/" + saveFile;
	}

}
