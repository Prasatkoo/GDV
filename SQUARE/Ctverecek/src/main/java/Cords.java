import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL33;
import org.lwjgl.system.MemoryUtil;
import java.nio.FloatBuffer;
public class Cords {

    public static final float coords[] = {
            -0.7f, -0.7f, 0.0f,
            0.7f, -0.7f, 0.0f,
            0.7f, 0.7f, 0.0f,
            -0.7f, -0.7f, 0.0f,
            -0.7f, 0.7f, 0.0f,
            0.7f, 0.7f, 0.0f
    };
    public static int trojaID;
    public static int trojbID;

    public static void init(long window) {

        Shadery.initShaders();
        trojaID = GL33.glGenVertexArrays();
        trojbID = GL33.glGenBuffers();

        GL33.glBindVertexArray(trojaID);

        GL33.glBindBuffer(GL33.GL_ARRAY_BUFFER, trojbID);

        FloatBuffer fb = BufferUtils.createFloatBuffer(coords.length)
                .put(coords)
                .flip();

        GL33.glBufferData(GL33.GL_ARRAY_BUFFER, fb, GL33.GL_STATIC_DRAW);
        GL33.glVertexAttribPointer(0, 3, GL33.GL_FLOAT, false, 0, 0);
        GL33.glEnableVertexAttribArray(0);

        MemoryUtil.memFree(fb);
    }
    public static void render(long window) {
        GL33.glUseProgram(Shadery.shaderProgramId);
        GL33.glBindVertexArray(trojaID);
        GL33.glDrawArrays(GL33.GL_TRIANGLES, 0, coords.length / 3);
    }
    public static void update(long window) {
    }

}