/*
// Licensed to DynamoBI Corporation (DynamoBI) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  DynamoBI licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
*/
package org.eigenbase.sql.validate;

import org.eigenbase.sql.*;


/**
 * An interface of an object identifier that represents a SqlIdentifier
 *
 * @author tleung
 * @version $Id$
 * @since May 24, 2005
 */
public interface SqlMoniker
{
    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the type of object referred to by this moniker. Never null.
     */
    SqlMonikerType getType();

    /**
     * Returns the array of component names.
     */
    String [] getFullyQualifiedNames();

    /**
     * Creates a {@link SqlIdentifier} containing the fully-qualified name.
     */
    SqlIdentifier toIdentifier();

    String id();
}

// End SqlMoniker.java
