/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package newtonsoft.vs.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class JacksonBenchmark {
    private ObjectMapper objectMapper;

    @Setup
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public String testSimpleClass() throws JsonProcessingException {
        return objectMapper.writerFor(SimpleClass.class)
                .writeValueAsString(
                        new SimpleClass()
                                .setId(1)
                                .setText("Test"));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public String testComplexClass() throws JsonProcessingException {
        return objectMapper.writerFor(ComplextClass.class)
                .writeValueAsString(
                        new ComplextClass()
                                .setId(1)
                                .setSimples(
                                        new SimpleClass[]{
                                                new SimpleClass().setId(1).setText("Test1"),
                                                new SimpleClass().setId(2).setText("Test2")})
                                .setValue(199.99));
    }

    public static class SimpleClass {
        private int id;
        private String text;

        public int getId() {
            return id;
        }

        public SimpleClass setId(int id) {
            this.id = id;
            return this;
        }

        public String getText() {
            return text;
        }

        public SimpleClass setText(String text) {
            this.text = text;
            return this;
        }
    }

    public static class ComplextClass {
        private int id;
        private SimpleClass[] simples;
        private double value;

        public int getId() {
            return id;
        }

        public ComplextClass setId(int id) {
            this.id = id;
            return this;
        }

        public SimpleClass[] getSimples() {
            return simples;
        }

        public ComplextClass setSimples(SimpleClass[] simples) {
            this.simples = simples;
            return this;
        }

        public double getValue() {
            return value;
        }

        public ComplextClass setValue(double value) {
            this.value = value;
            return this;
        }
    }
}
