package com.rodionov.osport.app.utils

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter : SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

object DateTimeFormatter : SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())

object DateYearFormatter : SimpleDateFormat("yyyy", Locale.getDefault())

object TimeFormatter : SimpleDateFormat("HH:mm", Locale.getDefault())

object MonthNameAndDateFormatter : SimpleDateFormat("dd MMMM", Locale.getDefault())

object MonthNameFormatter : SimpleDateFormat("MMMM", Locale.getDefault())

object MonthStandaloneNameFormatter : SimpleDateFormat("LLLL", Locale.getDefault())

object MonthStandaloneNameYearFormatter : SimpleDateFormat("LLLL yyyy", Locale.getDefault())

object ShortMonthNameFormatter : SimpleDateFormat("MMM", Locale.getDefault())

object MonthFormatter : SimpleDateFormat("MM.yyyy", Locale.getDefault())

object MonthDateTimeFormatter : SimpleDateFormat("dd MMM HH:mm", Locale.getDefault())

object ISODateTimeFormatter : SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.getDefault())

