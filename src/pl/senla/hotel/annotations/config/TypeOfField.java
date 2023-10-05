package pl.senla.hotel.annotations.config;

import java.lang.reflect.Field;

public enum TypeOfField {
    STRING {
        @Override
        public void setField(Field field, String propertyValue, Object config) throws IllegalAccessException {
            field.set(config, propertyValue);
        }
    },
    INTEGER {
        @Override
        public void setField(Field field, String propertyValue, Object config) throws IllegalAccessException {
            field.set(config, Integer.valueOf(propertyValue));
        }
    },
    BOOLEAN {
        @Override
        public void setField(Field field, String propertyValue, Object config) throws IllegalAccessException {
            field.set(config, Boolean.valueOf(propertyValue));
        }
    },
    BYTE {
        @Override
        public void setField(Field field, String propertyValue, Object config) throws IllegalAccessException {
            field.set(config, Byte.valueOf(propertyValue));
        }
    },
    SHORT {
        @Override
        public void setField(Field field, String propertyValue, Object config) throws IllegalAccessException {
            field.set(config, Short.valueOf(propertyValue));
        }
    },
    LONG {
        @Override
        public void setField(Field field, String propertyValue, Object config) throws IllegalAccessException {
            field.set(config, Long.valueOf(propertyValue));
        }
    },
    FLOAT {
        @Override
        public void setField(Field field, String propertyValue, Object config) throws IllegalAccessException {
            field.set(config, Float.valueOf(propertyValue));
        }
    },
    DOUBLE {
        @Override
        public void setField(Field field, String propertyValue, Object config) throws IllegalAccessException {
            field.set(config, Double.valueOf(propertyValue));
        }
    };

    public abstract void setField(Field field, String propertyValue, Object config) throws IllegalAccessException;
}
