package model;

import java.util.Date;

/**
 * 
 * @param id
 * @param name
 * @param date
 * @param amount
 */
public record Bill (int id, String name, Date date, double amount){}