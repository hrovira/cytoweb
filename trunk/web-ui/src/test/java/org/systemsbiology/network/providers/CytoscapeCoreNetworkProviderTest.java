package org.systemsbiology.network.providers;

import junit.framework.TestCase;
import org.systemsbiology.cytoweb.network.providers.CytoscapeCoreNetworkProvider;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 4:16:43 PM
 */
public class CytoscapeCoreNetworkProviderTest extends TestCase {
    /*
      Test Methods
     */
    public void testGetNetwork() throws Exception {
        CytoscapeCoreNetworkProvider provider = new CytoscapeCoreNetworkProvider();
        assertNotNull(provider.getNetwork());
    }
}
