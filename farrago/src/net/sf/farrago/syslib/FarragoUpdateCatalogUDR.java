/*
// $Id$
// Farrago is an extensible data management system.
// Copyright (C) 2005-2007 The Eigenbase Project
// Copyright (C) 2005-2007 Disruptive Tech
// Copyright (C) 2005-2007 LucidEra, Inc.
//
// This program is free software; you can redistribute it and/or modify it
// under the terms of the GNU General Public License as published by the Free
// Software Foundation; either version 2 of the License, or (at your option)
// any later version approved by The Eigenbase Project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
package net.sf.farrago.syslib;

import java.util.*;

import net.sf.farrago.catalog.*;
import net.sf.farrago.runtime.*;
import net.sf.farrago.session.*;


/**
 * FarragoUpdateCatalogUDR implements system procedures for updating Farrago
 * catalogs (intended for use as part of installation).
 *
 * @author Zelaine Fong
 * @version $Id$
 */
public class FarragoUpdateCatalogUDR
    extends FarragoAbstractCatalogInit
{
    //~ Constructors -----------------------------------------------------------

    private FarragoUpdateCatalogUDR(FarragoRepos repos)
    {
        super(repos);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Updates catalogs with system objects, adding them if they don't exist
     * yet.
     */
    public static void updateSystemObjects()
    {
        tracer.info("Updating system-owned catalog objects");
        FarragoSession session = FarragoUdrRuntime.getSession();
        FarragoRepos repos = session.getRepos();

        FarragoUpdateCatalogUDR init = null;
        FarragoReposTxnContext txn = repos.newTxnContext();
        try {
            txn.beginWriteTxn();
            init = new FarragoUpdateCatalogUDR(repos);
            init.updateSystemTypes();
            txn.commit();
        } finally {
            if (init != null) {
                // if txn is still in progress, it means we're handling
                // an exception, so pass rollback=true
                init.publishObjects(txn.isTxnInProgress());
            }
            txn.rollback();
        }
        tracer.info("Update of system-owned catalog objects committed");
    }
}

// End FarragoUpdateCatalogUDR.java