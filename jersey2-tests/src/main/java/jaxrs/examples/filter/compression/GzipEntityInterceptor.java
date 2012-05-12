package jaxrs.examples.filter.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.ws.rs.BindingPriority;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 * @author Santiago Pericas-Geertsen
 */
@Provider
@Gzipped
@BindingPriority(BindingPriority.DECODER)
public class GzipEntityInterceptor implements ReaderInterceptor, WriterInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext ctx) throws IOException {
        if (!gzipEncoded(ctx)) {
            return ctx.proceed();
        } else {
            InputStream old = ctx.getInputStream();
            ctx.setInputStream(new GZIPInputStream(old));
            try {
                return ctx.proceed();
            } finally {
                ctx.setInputStream(old);
            }
        }
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext ctx) throws IOException {
        if (!acceptsGzip(ctx)) {
            ctx.proceed();
        } else {
            OutputStream old = ctx.getOutputStream();
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(old);
            ctx.setOutputStream(gzipOutputStream);
            try {
                ctx.proceed();
            } finally {
                gzipOutputStream.finish();
                ctx.setOutputStream(old);
            }
        }
    }

    private boolean acceptsGzip(WriterInterceptorContext ctx) {
        // implementation goes here
        return true;
    }

    private boolean gzipEncoded(ReaderInterceptorContext ctx) {
        // implementation goes here
        return true;
    }
}
