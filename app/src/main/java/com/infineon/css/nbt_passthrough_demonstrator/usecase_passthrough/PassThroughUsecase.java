// SPDX-FileCopyrightText: 2024 Infineon Technologies AG
// SPDX-License-Identifier: MIT

package com.infineon.css.nbt_passthrough_demonstrator.usecase_passthrough;

import androidx.annotation.NonNull;

import com.infineon.hsw.apdu.ApduChannel;
import com.infineon.hsw.apdu.ApduCommand;
import com.infineon.hsw.apdu.ApduException;
import com.infineon.hsw.apdu.ApduResponse;

/**
 * The PassThroughUsecase Class represents the PassThrough Usecase with a NBT sample.
 * In this example setStateByPassThrough() is selecting a fake AID on the host MCU and a
 * LED state is changed by sending a byte for on or off state
 *
 */
public class PassThroughUsecase {

    /**
     * Establishes an interface channel with protocol (APDU) specific functionality
     */
    private final ApduChannel apduChannel;

    /**
     * Instance of the APDU response
     */
    private ApduResponse apduResponse;

    /**
     * Constructor validates parameters and saves them to members
     *
     * @param apduChannel APDU specific channel
     */
    public PassThroughUsecase(@NonNull ApduChannel apduChannel) {

        this.apduChannel = apduChannel;
        this.apduResponse = null;
    }

    /**
     * Selects fake AID on host and sets the state of the LED (on or off)
     *
     * @param state LED state (on or off)
     * @throws ApduException Thrown by command set of APDU library
     */
    public void setStateByPassThrough(boolean state) throws ApduException {

        ApduCommand apduCommand;
        apduCommand = selectPassThroughDemoAid();

        this.apduResponse = this.apduChannel.send(apduCommand);
        this.apduResponse.checkOK();

        //Demonstrator specific command
        apduCommand = setLedByPassthrough(state);

        this.apduResponse = this.apduChannel.send(apduCommand);
        this.apduResponse.checkOK();
    }

    /**
     * Creates a demonstrator specific apdu command to select the demonstrator passthrough AID
     *
     * @return apdu command to select aid
     * @throws ApduException Thrown by command set of APDU library
     */
    private ApduCommand selectPassThroughDemoAid() throws ApduException {

        int cla = 0x00;
        int ins = 0xA4;
        int p1 = 0x04;
        int p2 = 0x00;
        Object aid = new byte[]{(byte)0x01, (byte)0x02, (byte)0x03, (byte)0x04, (byte)0x05};
        int le = 0x00;

        return new ApduCommand(cla, ins, p1, p2, aid, le);
    }

    /**
     * Creates a demonstrator specific apdu command to control the LED of the passthrough demonstrator
     *
     * @return apdu command to enable/disable LED
     * @throws ApduException Thrown by command set of APDU library
     */
    private ApduCommand setLedByPassthrough(boolean state) throws ApduException {

        int cla = 0x00;
        int ins = 0x00;
        int p1 = 0x00;
        int p2 = state ? 0x01 : 0x00;   //On : Off
        int le = 0x00;

        return new ApduCommand(cla, ins, p1, p2, null, le);
    }
}

