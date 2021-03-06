/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.sal.topology;

import java.util.List;
import org.opendaylight.controller.sal.core.Edge;

/**
 * This interface defines the methods that are invoked from Protocol Plugin
 * toward SAL. Every time a protocol plugin update the topology, it will call
 * this service provided by SAL so the update can migrate upward toward the
 * applications.
 */
public interface IPluginOutTopologyService {

    /**
     * Called to update on Edge in the topology graph
     *
     * @param topoedgeupdateList
     *            List of topoedgeupdates Each topoedgeupdate includes edge, its
     *            Properties ( BandWidth and/or Latency etc) and update type.
     */
    public void edgeUpdate(List<TopoEdgeUpdate> topoedgeupdateList);

    /**
     * Called when an Edge utilization is above the safety threshold configured
     * on the controller
     *
     * @param edge
      *            The edge which bandwidth usage is above the safety level
    */
    public void edgeOverUtilized(Edge edge);

    /**
     * Called when the Edge utilization is back to normal, below the safety
     * threshold level configured on the controller
     *
     * @param edge
     *            The edge which bandwidth usage is back to normal
     */
    public void edgeUtilBackToNormal(Edge edge);
}
