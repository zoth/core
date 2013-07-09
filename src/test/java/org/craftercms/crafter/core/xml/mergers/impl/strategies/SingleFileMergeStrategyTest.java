/*
 * Copyright (C) 2007-2013 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.crafter.core.xml.mergers.impl.strategies;

import org.craftercms.core.xml.mergers.impl.strategies.SingleFileMergeStrategy;
import org.junit.Before;
import org.junit.Test;
import org.craftercms.core.xml.mergers.MergeableDescriptor;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Class description goes HERE
 *
 * @author Alfonso Vásquez
 */
public class SingleFileMergeStrategyTest {

    private static final String PRIMARY_DESCRIPTOR_URL = "/folder/sub-folder/descriptor.xml";

    private SingleFileMergeStrategy strategy;

    @Before
    public void setUp() throws Exception {
        setUpTestStrategy();
    }

    @Test
    public void testGetDescriptors() throws Exception {
        List<MergeableDescriptor> descriptors = strategy.getDescriptors(null, null, PRIMARY_DESCRIPTOR_URL);
        assertDescriptors(descriptors, false);

        descriptors = strategy.getDescriptors(null, null, PRIMARY_DESCRIPTOR_URL, false);
        assertDescriptors(descriptors, false);

        descriptors = strategy.getDescriptors(null, null, PRIMARY_DESCRIPTOR_URL, true);
        assertDescriptors(descriptors, true);
    }

    private void setUpTestStrategy() {
        strategy = new SingleFileMergeStrategy();
    }

    private void assertDescriptors(List<MergeableDescriptor> descriptors, boolean primaryDescriptorOptional) {
        assertEquals(1, descriptors.size());
        assertEquals(PRIMARY_DESCRIPTOR_URL, descriptors.get(0).getUrl());
        assertEquals(primaryDescriptorOptional, descriptors.get(0).isOptional());
    }

}
