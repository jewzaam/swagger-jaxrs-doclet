package com.hypnoticocelot.jaxrs.doclet.model;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;
import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.AnnotationDesc.ElementValuePair;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.AnnotationValue;

public class Produce {

    private static String PRODUCES_ANNOTATION_CLASS = "javax.ws.rs.Produces";
    private static String PRODUCES_VALUE = "value";

    private String mediaType;

    public static List<Produce> fromMethod(MethodDoc method) {
        List<Produce> produces = new ArrayList<Produce>();
        
        for (AnnotationDesc annotation : method.annotations()) {
            if (PRODUCES_ANNOTATION_CLASS.equals(annotation.annotationType().qualifiedTypeName())) {
                // get 'value' element's value, this is the produces bit
                for (ElementValuePair evp : annotation.elementValues()) {
                    if (PRODUCES_VALUE.equals(evp.element().name())) {
                        for (AnnotationValue a: ((AnnotationValue[])((AnnotationValue)evp.value()).value())) {
                            produces.add(new Produce(a.toString().replace("\"", "")));
                        }
                    }
                }
            }
        }
        return produces;
    }

    public Produce(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Produce that = (Produce) o;
        return Objects.equal(mediaType, that.mediaType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mediaType);
    }

    @Override
    public String toString() {
        return mediaType;
    }
}
