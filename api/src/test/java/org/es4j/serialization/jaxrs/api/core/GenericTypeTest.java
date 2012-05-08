package org.es4j.serialization.jaxrs.api.core;

import org.es4j.serialization.jaxrs.api.core.GenericType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Type literal construction unit tests.
 *
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
public class GenericTypeTest {

    private static final Type arrayListOfStringsType = new ArrayList<String>() {

        private static final long serialVersionUID = 3109256773218160485L;
    }.getClass().getGenericSuperclass();

    public GenericTypeTest() {
    }

    @Test
    public void testStaticConstruction() {

        GenericType<ArrayList<String>> type = GenericType.<ArrayList<String>>of(ArrayList.class,new ParameterizedType(){

            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{String.class};
            }

            @Override
            public Type getRawType() {
                return ArrayList.class;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        });
        assertEquals(ArrayList.class, type.getRawType());
        assertEquals(arrayListOfStringsType, type.getType());
        final Type[] parameterTypes = type.getParameterTypes();

        assertEquals(1, parameterTypes.length);
        assertEquals(String.class, parameterTypes[0]);
    }

    @Test
    public void testAnnonymousConstruction() {
        GenericType<ArrayList<String>> tl = new GenericType<ArrayList<String>>() { };
        assertEquals(ArrayList.class, tl.getRawType());
        assertEquals(arrayListOfStringsType, tl.getType());
        final Type[] parameterTypes = tl.getParameterTypes();

        assertEquals(1, parameterTypes.length);
        assertEquals(String.class, parameterTypes[0]);
    }
}
