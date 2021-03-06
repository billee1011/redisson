/**
 * Copyright 2014 Nikita Koksharov, Nickolay Borbit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.core;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

import io.netty.util.concurrent.Future;

/**
 * Async interface for {@link BlockingDeque} backed by Redis
 *
 * @author Nikita Koksharov
 * @param <V> the type of elements held in this collection
 */
public interface RBlockingDequeAsync<V> extends RDequeAsync<V>, RBlockingQueueAsync<V> {

    /**
     * Retrieves and removes first available head element of <b>any</b> queue in async mode,
     * waiting up to the specified wait time if necessary for an element to become available
     * in any of defined queues <b>including</b> queue own.
     *
     * @param timeout how long to wait before giving up, in units of
     *        {@code unit}
     * @param unit a {@code TimeUnit} determining how to interpret the
     *        {@code timeout} parameter
     * @return the head of this queue, or {@code null} if the
     *         specified waiting time elapses before an element is available
     * @throws InterruptedException if interrupted while waiting
     */
    Future<V> pollFirstFromAnyAsync(long timeout, TimeUnit unit, String ... queueNames);

    /**
     * Retrieves and removes first available tail element of <b>any</b> queue in async mode,
     * waiting up to the specified wait time if necessary for an element to become available
     * in any of defined queues <b>including</b> queue own.
     *
     * @param timeout how long to wait before giving up, in units of
     *        {@code unit}
     * @param unit a {@code TimeUnit} determining how to interpret the
     *        {@code timeout} parameter
     * @return the head of this queue, or {@code null} if the
     *         specified waiting time elapses before an element is available
     * @throws InterruptedException if interrupted while waiting
     */
    Future<V> pollLastFromAnyAsync(long timeout, TimeUnit unit, String ... queueNames);

    Future<Void> putFirstAsync(V e);

    Future<Void> putLastAsync(V e);

    Future<V> pollLastAsync(long timeout, TimeUnit unit);

    Future<V> takeLastAsync();

    Future<V> pollFirstAsync(long timeout, TimeUnit unit);

    Future<V> takeFirstAsync();
}
