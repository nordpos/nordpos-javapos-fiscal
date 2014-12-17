/**
 *
 * NORD POS is a fork of Openbravo POS.
 *
 * Copyright (C) 2009-2014 Nord Trading Ltd. <http://www.nordpos.com>
 *
 * This file is part of NORD POS.
 *
 * NORD POS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * NORD POS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * NORD POS. If not, see <http://www.gnu.org/licenses/>.
 */
package com.nordpos.device.javapos;

import com.nordpos.device.FiscalPrinterInterface;
import com.nordpos.device.fiscalprinter.DeviceFiscalPrinter;
import com.nordpos.device.fiscalprinter.DeviceFiscalPrinterNull;
import com.nordpos.device.util.StringParser;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 * @version NORD POS 3.0
 */
public class FiscalPrinterDriver implements FiscalPrinterInterface {
   
    @Override
    public DeviceFiscalPrinter getFiscalPrinter(String sProperty) throws Exception {
        StringParser sf = new StringParser(sProperty);
        String sFiscalType = sf.nextToken(':');
        String sFiscalParam1 = sf.nextToken(',');

        switch (sFiscalType) {
            case "javapos":
                return new DeviceFiscalPrinterJavaPOS(sFiscalParam1);        
            default:
                return new DeviceFiscalPrinterNull();
        }
    }
 
}
