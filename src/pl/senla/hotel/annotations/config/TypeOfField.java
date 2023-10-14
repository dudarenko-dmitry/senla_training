package pl.senla.hotel.annotations.config;

import java.lang.reflect.Field;

public enum TypeOfField {
    STRING {
        @Override
        public void setField(Field field, String propertyValue, Object object) throws IllegalAccessException {
            field.set(object, propertyValue);
        }
    },
    INTEGER {
        @Override
        public void setField(Field field, String propertyValue, Object object) throws IllegalAccessException {
            field.set(object, Integer.valueOf(propertyValue));
        }
    },
    BOOLEAN {
        @Override
        public void setField(Field field, String propertyValue, Object object) throws IllegalAccessException {
            field.set(object, Boolean.valueOf(propertyValue));
        }
    },
    BYTE {
        @Override
        public void setField(Field field, String propertyValue, Object object) throws IllegalAccessException {
            field.set(object, Byte.valueOf(propertyValue));
        }
    },
    SHORT {
        @Override
        public void setField(Field field, String propertyValue, Object object) throws IllegalAccessException {
            field.set(object, Short.valueOf(propertyValue));
        }
    },
    LONG {
        @Override
        public void setField(Field field, String propertyValue, Object object) throws IllegalAccessException {
            field.set(object, Long.valueOf(propertyValue));
        }
    },
    FLOAT {
        @Override
        public void setField(Field field, String propertyValue, Object object) throws IllegalAccessException {
            field.set(object, Float.valueOf(propertyValue));
        }
    },
    DOUBLE {
        @Override
        public void setField(Field field, String propertyValue, Object object) throws IllegalAccessException {
            field.set(object, Double.valueOf(propertyValue));
        }
    };

    public abstract void setField(Field field, String propertyValue, Object object) throws IllegalAccessException;
}
