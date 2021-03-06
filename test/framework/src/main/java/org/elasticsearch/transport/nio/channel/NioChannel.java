/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.transport.nio.channel;

import org.elasticsearch.transport.nio.ESSelector;

import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NetworkChannel;
import java.nio.channels.SelectionKey;

public interface NioChannel {

    String CLIENT = "client-socket";

    boolean isOpen();

    InetSocketAddress getLocalAddress();

    String getProfile();

    CloseFuture closeAsync();

    void closeFromSelector();

    boolean register(ESSelector selector) throws ClosedChannelException;

    ESSelector getSelector();

    SelectionKey getSelectionKey();

    CloseFuture getCloseFuture();

    NetworkChannel getRawChannel();
}
