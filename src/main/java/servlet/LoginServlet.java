package servlet;

import dao.EstudiantewebJpaController;
import dto.Estudianteweb;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONObject;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private EstudiantewebJpaController controller;

    @Override
    public void init() throws ServletException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_preg01_war_1.0-SNAPSHOTPU");
        controller = new EstudiantewebJpaController(emf);
    }

    // Buscar estudiante por código y responder JSON
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        try {
            int cod = Integer.parseInt(req.getParameter("codigo"));
            Estudianteweb est = controller.findEstudianteweb(cod);

            JSONObject obj = new JSONObject();
            if (est != null) {
                obj.put("codigo", est.getCodiEstdWeb());
                obj.put("dni", est.getNdniEstdWeb());
                obj.put("apellidoPaterno", est.getAppEstdWeb());
                obj.put("apellidoMaterno", est.getApmaEstWeb());
                obj.put("nombre", est.getNombEstdWeb());
                obj.put("login", est.getLogiEstd());
            } else {
                obj.put("error", "Estudiante no encontrado");
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

            resp.getWriter().print(obj.toString());

        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print("{\"error\": \"Código inválido\"}");
        }
    }

    // Validar login
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        List<Estudianteweb> estudiantes = controller.findEstudiantewebEntities();

        for (Estudianteweb e : estudiantes) {
            if (e.getLogiEstd().equals(login) && e.getPassEstd().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", e);
                response.sendRedirect("index.html");
                return;
            }
        }

        response.sendRedirect("login.html?error=invalid");
    }

    // Actualizar contraseña (por JSON)
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        BufferedReader reader = req.getReader();
        StringBuilder jsonB = new StringBuilder();
        String linea;
        while ((linea = reader.readLine()) != null) {
            jsonB.append(linea);
        }

        JSONObject jsonObject = new JSONObject(jsonB.toString());

        try {
            int cod = jsonObject.getInt("codigo");
            String nuevaPass = jsonObject.getString("nuevaContrasena");

            Estudianteweb est = controller.findEstudianteweb(cod);
            if (est != null) {
                est.setPassEstd(nuevaPass);
                controller.edit(est);
                resp.getWriter().print("{\"mensaje\": \"Contraseña actualizada\"}");
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().print("{\"error\": \"Estudiante no encontrado\"}");
            }

        } catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().print("{\"error\": \"Error interno\"}");
        }
    }
}
