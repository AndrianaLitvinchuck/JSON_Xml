/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmljsons;

import java.io.File;

public interface XmlJsons {

    void serialize(Object object, File file);
    Object deserialize(Class c, File file);
}

