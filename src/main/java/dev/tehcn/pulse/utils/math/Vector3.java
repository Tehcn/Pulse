package dev.tehcn.pulse.utils.math;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.util.math.Vec3d;
import java.util.Random;

public class Vector3 {
    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 add(Vector3 v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }

    public Vector3 sub(Vector3 v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        return this;
    }

    public Vector3 mul(Vector3 v) {
        this.x *= v.x;
        this.y *= v.y;
        this.z *= v.z;
        return this;
    }

    public Vector3 div(Vector3 v) {
        this.x /= v.x;
        this.y /= v.y;
        this.z /= v.z;
        return this;
    }

    public Vec3d toVec3d() {
        return new Vec3d(this.x, this.y, this.z);
    }

    public Vector3d toVector3d() {
        return new Vector3d(this.x, this.y, this.z);
    }

    public static Vector3 Vec3dtoVector3(Vec3d v) {
        return new Vector3(v.x, v.y, v.z);
    }

    public static Vector3 Vector3dtoVector3(Vector3d v) {
        return new Vector3(v.x, v.y, v.z);
    }

    public static Vector3d Vec3dtoVector3d(Vec3d v) {
        return new Vector3d(v.x, v.y, v.z);
    }

    public static Vec3d Vector3dtoVec3d(Vector3d v) {
        return new Vec3d(v.x, v.y, v.z);
    }

    /**
     * @param min minimum value
     * @param max maximum value
     * @return returns a Vector3
     */
    public static Vector3 randomVector3(Vector3 min, Vector3 max) {
        Random gen = new Random();
        double x = gen.nextDouble(min.x, max.x);
        double y = gen.nextDouble(min.y, max.y);
        double z = gen.nextDouble(min.z, max.z);
        return new Vector3(x, y, z);
    }

    /**
     * @param min minimum value
     * @param max maximum value
     * @return returns a Vec3d
     */
    public static Vec3d randomVec3d(Vec3d min, Vec3d max) {
        return Vector3.randomVector3(Vec3dtoVector3(min), Vec3dtoVector3(max)).toVec3d();
    }

    /**
     * @param min minimum value
     * @param max maximum value
     * @return returns a Vector3d
     */
    public static Vector3d randomVector3d(Vector3d min, Vector3d max) {
        return Vector3.randomVector3(Vector3dtoVector3(min), Vector3dtoVector3(max)).toVector3d();
    }
}
