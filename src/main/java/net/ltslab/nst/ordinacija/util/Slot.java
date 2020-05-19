/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.util;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author bobanlukic
 */
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Slot implements Serializable {

    private static final long serialVersionUID = -3218454298506311302L;

    private LocalDate date;

    private LocalTime time;

    private int partNumber;

    private boolean occupied;
}