<%@ page import="web.HortonData" %>

<html>

  <head>
    <title>Student Grades</title>
  </head>
  
  <style>
      th, tr, td, table {
        border: 1px solid black;
        border-collapse: collapse;
      }
  </style>
  
  <body>
  
  <h1>Mrs. Horton's 4th Grade Class</h1>
  
  <h1><%= "Mrs. Horton's 4th Grade Class" %></h1>
  
  <h1><%= HortonData.TEACHER %>'s 4th Grade Class</h1>
  
  <table>
      <tr>
          <th>Name</th><th>Grade</th><th>Subject</th>
      </tr>
      
      
      <% for(int i=0;i<HortonData.SAMPLE_DATA.length;++i) { %>
      <tr>      
          <td><%=HortonData.SAMPLE_DATA[i][0] %></td>
          <td><%=HortonData.SAMPLE_DATA[i][1] %></td>
          <td><%=HortonData.SAMPLE_DATA[i][2] %></td>
      </tr>
      <% } %>      
  
  </table>
  
  <p>

  </body>
</html> 
