import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33;

public class Main {

    public static void main(String[] args) throws Exception {
        GLFW.glfwInit();

        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);

        long window = GLFW.glfwCreateWindow(900, 700, "First window puta", 0, 0);
        if (window == 0) {
            GLFW.glfwTerminate();
            throw new Exception("Can't open nigga");
        }
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GL33.glViewport(0, 0, 800, 600);

        GLFW.glfwSetFramebufferSizeCallback(window, (win, w, h) -> {
            GL33.glViewport(0, 0, w, h);
        });
        Cords.init(window);
        while (!GLFW.glfwWindowShouldClose(window)) {

            if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_ESCAPE) == GLFW.GLFW_PRESS)
                GLFW.glfwSetWindowShouldClose(window, true);

            GL33.glClearColor(0f, 1f, 1f, 1f);
            GL33.glClear(GL33.GL_COLOR_BUFFER_BIT);

            Cords.render(window);
            Cords.update(window);

            GLFW.glfwSwapBuffers(window);

            GLFW.glfwPollEvents();
        }

        GLFW.glfwTerminate();
    }

}